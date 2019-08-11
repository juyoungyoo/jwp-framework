package core.mvc.tobe;

import core.mvc.ModelAndView;
import core.mvc.asis.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class HandlerExecution {

    private Object controller;
    private Method method;

    public HandlerExecution(Object controller, Method method) {
        this.controller = controller;
        this.method = method;
    }

    public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return (ModelAndView) method.invoke(controller, request, response);
    }

    @Override
    public String toString() {
        return "HandlerExecution{" +
                "controller=" + controller +
                ", method=" + method +
                '}';
    }
}