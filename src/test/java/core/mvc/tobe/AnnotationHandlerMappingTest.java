package core.mvc.tobe;

import core.mvc.ModelAndView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class AnnotationHandlerMappingTest {

    private static final String DEFAULT_PACKAGE = "core.mvc.tobe";
    private AnnotationHandlerMapping handlerMapping;

    @BeforeEach
    void setup() {
        handlerMapping = new AnnotationHandlerMapping(DEFAULT_PACKAGE);
        handlerMapping.initialize();
    }

    @DisplayName(DEFAULT_PACKAGE + " 중 controller 어노테이션 클래스에 해당되며 매핑되는 핸들러가 있을 경우 성공한다")
    @ParameterizedTest
    @CsvSource({
            "'GET', '/users'",
            "'POST', '/users'",
            "'GET', '/users/findUserId'",
    })
    void handle_isExistRequest_isNotNull(String method, String url) {
        // given
        MockHttpServletRequest request = new MockHttpServletRequest(method, url);
        MockHttpServletResponse response = new MockHttpServletResponse();

        // when
        ModelAndView handler = handlerMapping.handle(request, response);

        // then
        assertThat(handler).isNotNull();
    }

    @DisplayName(DEFAULT_PACKAGE + "controller 어노테이션의 객체에 매핑되는 핸들러가 없을 경우 exception")
    @Test
    void handle_isNotExistRequest_exception() {
        // given
        MockHttpServletRequest request = new MockHttpServletRequest("GET", "/users/1");
        MockHttpServletResponse response = new MockHttpServletResponse();

        // when && exception
        assertThatExceptionOfType(NotFoundServletException.class)
                .isThrownBy(() -> handlerMapping.handle(request, response));
    }

    @DisplayName(DEFAULT_PACKAGE + "에 매핑되는 핸들러가 있는지 확인한다")
    @ParameterizedTest
    @CsvSource({
            "'GET', '/users/findUserId', 'true'",
            "'GET', '/users/1', 'false'",
    })
    void isExistHandler(String method, String url, boolean result) {
        // given
        MockHttpServletRequest request = new MockHttpServletRequest(method, url);

        // then
        assertThat(handlerMapping.supports(request)).isEqualTo(result);
    }
}