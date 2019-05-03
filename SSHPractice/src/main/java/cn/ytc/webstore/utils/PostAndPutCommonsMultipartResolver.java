package cn.ytc.webstore.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class PostAndPutCommonsMultipartResolver extends CommonsMultipartResolver {

	/*
	 * (non-Javadoc)
	 * @see org.springframework.web.multipart.commons.CommonsMultipartResolver# override
	 * public boolean isMultipart(javax.servlet.http.HttpServletRequest)
	 * 	public boolean isMultipart(HttpServletRequest request) {
		return ServletFileUpload.isMultipartContent(request);
	}
	 */
	
    @Override
    public boolean isMultipart(HttpServletRequest request) {
        if ("POST".equalsIgnoreCase(request.getMethod()) || "PUT".equalsIgnoreCase(request.getMethod())) {
            return FileUploadBase.isMultipartContent(new ServletRequestContext(request));
        }
        return false;
    }

}