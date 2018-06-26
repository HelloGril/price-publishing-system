package com.hywa.pricepublish.config.redisPojo;

/**微信企业号 的 AccessToken 获取类
 * by yfw
 * */
public class WeChatAccessToken {

	
	/**企业的 accessToken */
	private String accessTokenGs;
	
	/**通讯的 accessToken */
	private String accessTokenTx;
	
	/**JS-sdk 的权限 jsapiTicket */
	private String jsapiTicket;

	public String getAccessTokenGs() {
		return accessTokenGs;
	}

	public void setAccessTokenGs(String accessTokenGs) {
		this.accessTokenGs = accessTokenGs;
	}

	public String getAccessTokenTx() {
		return accessTokenTx;
	}

	public void setAccessTokenTx(String accessTokenTx) {
		this.accessTokenTx = accessTokenTx;
	}

	public String getJsapiTicket() {
		return jsapiTicket;
	}

	public void setJsapiTicket(String jsapiTicket) {
		this.jsapiTicket = jsapiTicket;
	}
	

		
}
