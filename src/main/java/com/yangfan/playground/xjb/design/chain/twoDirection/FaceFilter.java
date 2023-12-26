package com.yangfan.playground.xjb.design.chain.twoDirection;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年3月6日 下午3:48:03
 */

public class FaceFilter implements Filter {

	@Override
	public void doFilter(Request request, Response response,FilterChain fc) {
		 request.requestStr = request.getRequestStr().replace(":)", "^_^");
		 
		 fc.doFilter(request, response, fc);
		 
		 response.responseStr += "FaceFilter---->";
	}

}
