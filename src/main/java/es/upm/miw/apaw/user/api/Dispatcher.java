package es.upm.miw.apaw.user.api;

import es.upm.miw.apaw.user.api.resources.SportResource;
import es.upm.miw.apaw.user.api.resources.UserResource;
import es.upm.miw.apaw.user.http.HttpRequest;
import es.upm.miw.apaw.user.http.HttpResponse;
import es.upm.miw.apaw.user.http.HttpStatus;
import es.upm.miw.apaw.user.resources.exceptions.RequestInvalidException;

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
            	response.setBody(sportResource.readSport(Integer.valueOf(request.getBody())));
            } else if (request.isEqualsPath(UserResource.USER + SportResource.ID)) {   
            	response.setBody(userResource.readUser(Integer.valueOf(request.getBody())));
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
            	sportResource.createSport(request.getBody());
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
            if (request.isEqualsPath(UserResource.USER + SportResource.SPORT)) {
            	String userId = request.getBody().split(":")[0];  // body="userId:sportId"
                String sportId = request.getBody().split(":")[1]; 
            	userResource.addSport(Integer.valueOf(userId), Integer.valueOf(sportId));
                response.setStatus(HttpStatus.OK);
            } else {
                throw new RequestInvalidException(request.getPath());
            }
        } catch (Exception e) {
            responseError(response, e);
        }
    }

    public void doPatch(HttpRequest request, HttpResponse response) {
    	 try {
             if (request.isEqualsPath(UserResource.USER + UserResource.ID + UserResource.ACTIVE) ) {
            	 userResource.modifyActive(Integer.valueOf(request.getBody()));
                 response.setStatus(HttpStatus.OK);
             } else if (request.isEqualsPath(SportResource.SPORT + UserResource.ID + SportResource.CATEGORY) ) {
            	 sportResource.modifyCategory(Integer.valueOf(request.getBody()));
            	 response.setStatus(HttpStatus.OK);
             } else {
                 throw new RequestInvalidException(request.getPath());
             }
         } catch (Exception e) {
             responseError(response, e);
         }
    }

    public void doDelete(HttpRequest request, HttpResponse response) {
          responseError(response, new RequestInvalidException(request.getPath()));
    }

}
