package com.liferay.serve.resource.web.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.serve.resource.model.Continent;
import com.liferay.serve.resource.service.ContinentLocalService;
import com.liferay.serve.resource.web.constants.CountryWebPortletKeys;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Argil DX
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=CountryWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + CountryWebPortletKeys.COUNTRYWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CountryWebPortlet extends MVCPortlet {
	
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {
		
		List<Continent> continent = continentLocalService.findAll();
		
		renderRequest.setAttribute("continent",continent);
		super.render(renderRequest, renderResponse);
	}
	
	@Reference
	ContinentLocalService continentLocalService;
}