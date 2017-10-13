package es.upm.miw.apaw.user.api;

import es.upm.miw.apaw.user.api.resources.SportResource;
import es.upm.miw.apaw.user.api.resources.UserResource;
import es.upm.miw.apaw.user.http.HttpRequest;
import es.upm.miw.apaw.user.http.HttpResponse;
import es.upm.miw.apaw.user.http.HttpStatus;
import es.upm.miw.user.api.resources.exceptions.RequestInvalidException;

public class Dispatcher {
    private UserResource userResource = new UserResource();
    private SportResource sportResource = new SportResource();
    
    private void responseError(HttpResponse response, Exception e) {
        response.setBody("{\"error\":\"" + e + "\"}");
        response.setStatus(HttpStatus.BAD_REQUEST);
    }

    public void doGet(HttpRequest request, HttpResponse response) {
    	try {
            if (request.isEqualsPath(SportResource.SPORT + SportResource.ID)) { 
            	response.setBody(sportResource.readSport(Long.valueOf(request.paths()[1])).toString());
            } else if (request.isEqualsPath(UserResource.USER + UserResource.ID)) {   
            	response.setBody(userResource.readUser(Long.valueOf(request.paths()[1])).toString());
            } else {
               throw new RequestInvalidException(request.getPath());
            }
        } catch (Exception e) {
            responseError(response, e);
        } 
    }

    public void doPost(HttpRequest request, HttpResponse response) {
    	try {
            if (request.isEqualsPath(SportResource.SPORT)) {
            	String title = request.getBody().split(":")[0]; // body="title:category"
                String category = request.getBody().split(":")[1];
            	sportResource.createSport(title, category);
                response.setStatus(HttpStatus.CREATED);
            } else if (request.isEqualsPath(UserResource.USER)) {
            	userResource.createUser(request.getBody());
                response.setStatus(HttpStatus.CREATED);
            } else {
                throw new RequestInvalidException(request.getPath());
            }
        } catch (Exception e) {
            responseError(response, e);
        }
    }
 
    public void doPut(HttpRequest request, HttpResponse response) {
    	 try {
    		 /*
             if (request.isEqualsPath(UserResource.USER + UserResource.ID + UserResource.SPORT)) {
             	String userId =  request.paths()[1];
                String sportId = request.getBody(); 
             	response.setBody(userResource.linkSportToUser(Integer.valueOf(userId), Integer.valueOf(sportId)).toString());
                response.setStatus(HttpStatus.OK);
             } else {
                 throw new RequestInvalidException(request.getPath());
             }
             */
         } catch (Exception e) {
             responseError(response, e);
         }
    }

    public void doPatch(HttpRequest request, HttpResponse response) {
    	try {
    		/*
            if (request.isEqualsPath(UserResource.USER + UserResource.ID + UserResource.ACTIVE) ) {
           	 Integer userId = Integer.valueOf(request.paths()[1]);
           	 boolean activeState = Boolean.valueOf(request.getBody());
           	 response.setBody(userResource.modifyActive(userId, activeState).toString());
             response.setStatus(HttpStatus.OK);
            } else if (request.isEqualsPath(SportResource.SPORT + SportResource.ID + SportResource.CATEGORY) ) {
           	 Integer sportId = Integer.valueOf(request.paths()[1]);
           	 String  category = request.getBody();
           	 response.setBody(sportResource.modifyCategory(sportId, category).toString());
           	 response.setStatus(HttpStatus.OK);
            } else {
                throw new RequestInvalidException(request.getPath());
            }
            */
        } catch (Exception e) {
            responseError(response, e);
        }
    }

    public void doDelete(HttpRequest request, HttpResponse response) {
          responseError(response, new RequestInvalidException(request.getPath()));
    }
}

