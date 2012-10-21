package com.viddu.agile.resources;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.api.view.Viewable;
import com.sun.jersey.spi.template.ViewProcessor;

@Provider
public class MustacheViewProcessor implements ViewProcessor<String> {
	private static final String MUSTACHE_TEMPLATES_BASE_PATH = "com.sun.jersey.mustache.templateBasePath";

	private @Context
	UriInfo uriInfo;

	private @Context
	ServletContext servletContext;

	private @Context
	ThreadLocal<HttpServletRequest> requestInvoker;

	private @Context
	ThreadLocal<HttpServletResponse> responseInvoker;

	private final String basePath;

	public MustacheViewProcessor(@Context ResourceConfig resourceConfig) {
		String path = (String) resourceConfig.getProperties().get(MUSTACHE_TEMPLATES_BASE_PATH);
		if (path == null)
			this.basePath = "";
		else if (path.charAt(0) == '/') {
			this.basePath = path;
		} else {
			this.basePath = "/" + path;
		}
	}

	public String resolve(String path) {
		if (basePath != "")
			path = basePath + path;
		
	    ClassLoader ccl = Thread.currentThread().getContextClassLoader();
		if (ccl.getResourceAsStream(path) != null) {
			return path;
		}

		if (!path.endsWith(".mustache")) {
			path = path + ".mustache";
			if (ccl.getResourceAsStream(path) != null) {
				return path;
			}
		}
		return null;
	}

	public void writeTo(String resolvedPath, Viewable viewable, OutputStream out) throws IOException {
		// Commit the status and headers to the HttpServletResponse
		out.flush();

		MustacheFactory mf = new DefaultMustacheFactory();
		Mustache mustache = mf.compile(resolvedPath);
		Writer writer = new OutputStreamWriter(out);
		mustache.execute(writer , viewable.getModel());
		writer.flush();
	}
}
