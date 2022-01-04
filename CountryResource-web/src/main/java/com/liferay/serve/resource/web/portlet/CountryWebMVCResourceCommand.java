package com.liferay.serve.resource.web.portlet;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.serve.resource.model.Country;
import com.liferay.serve.resource.model.States;
import com.liferay.serve.resource.service.CountryLocalService;
import com.liferay.serve.resource.service.StatesLocalService;
import com.liferay.serve.resource.web.constants.CountryWebPortletKeys;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    immediate = true,
	    property = {
	       "javax.portlet.name=" + CountryWebPortletKeys.COUNTRYWEB,
	       "mvc.command.name=/serveResource"
	    },
	    service = MVCResourceCommand.class
	)
public class CountryWebMVCResourceCommand implements MVCResourceCommand {

	
	
		@Override
	    public boolean serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse) throws PortletException {
	        String countryList = "";
	        String countryCode ="";
	        String statesList ="";
	       
	        String continentCode = ParamUtil.getString(resourceRequest, "continentCode");
	        String continentSelected = ParamUtil.getString(resourceRequest, "continentSelected");
	       System.out.println("continentCode :--"+continentCode);
	       System.out.println("continentSelected:---"+continentSelected);
	        String countrySelectedCode= ParamUtil.getString(resourceRequest, "countrySelectedCode");
	        String countrySelected = ParamUtil.getString(resourceRequest, "countrySelected");
	       
	        System.out.println("countrySelectedCode :---"+countrySelectedCode);
	        
	        System.out.println("countrySelected :----"+countrySelected);
	        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
	       
	        if(continentSelected.equalsIgnoreCase("continentSelected")){
	            try {
	                List<Country> countryLi = countryLocalService.getByContinentCode(continentCode); // to get list of country available based on continent Code
	                System.out.println("Country List"+countryLi);
	            for(Country  conList : countryLi){
	                countryList =conList.getCountryName();
	                countryCode = conList.getCountryCode();
	                JSONObject jsonObject = JSONFactoryUtil.createJSONObject(); //creating json object parse the request using json object 

	                jsonObject.put("countryList",countryList );
	                jsonObject.put("countryCode", countryCode);
	                jsonArray.put(jsonObject);
	            }
	           
	        } catch (SystemException e) {
	                       e.printStackTrace();
	        }
	        }
	       
	        if(countrySelected.equalsIgnoreCase("countrySelected")){
	            try {
	                List<States> states = statesLocalService.getByCountryCode(countrySelectedCode);
	                for(States statesList2 : states){
	                    statesList = statesList2.getStateName();
	                    JSONObject jsonObject2 = JSONFactoryUtil.createJSONObject();
	                    jsonObject2.put("statesList3", statesList);
	                    jsonArray.put(jsonObject2);
	                   
	                }
	            } catch (SystemException e) {
	                               e.printStackTrace();
	            }
	        }
	       
	        PrintWriter writer = null;
			try {
				writer = resourceResponse.getWriter();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        writer.write(jsonArray.toString());
	        writer.flush();
			return true;
	    }
		@Reference
		CountryLocalService countryLocalService;
		
		@Reference
		StatesLocalService statesLocalService;
	}
