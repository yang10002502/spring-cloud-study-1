package com.xin.eurekazuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Jack_yang
 * @Date: 2019/6/27 19:28
 */
@Component
public class TokenFilter extends ZuulFilter {
    /**
     * 四种类型：pre、routing、error、post
     * pre：主要用在路由映射的阶段时寻找路由映射表的
     * routing：具体的路由转发过滤器，具体的请求转发时会调用
     * error：一旦前面的过滤器出错了，会调用error过滤器
     * post：当routing、error运行完后才会调用该过滤器，是在最后阶段的
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 自定义过滤器执行的顺序，数值越大越靠后执行，越小越先执行
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 控制过滤器生效与否，可以在其中写一串逻辑来控制
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 执行过滤器逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String token = request.getParameter("token");
        if(token == null){
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            context.setResponseBody("unauthorized");
            return null;
        }
        return null;
    }
}
