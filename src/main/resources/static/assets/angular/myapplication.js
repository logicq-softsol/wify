/**
 * 
 */

(function () {
    'use strict';
    
   angular.module('wifyApp', ['ui.router','ngMessages','ngSanitize','com.2fdevs.videogular',
                              'com.2fdevs.videogular.plugins.controls',
                              'com.2fdevs.videogular.plugins.poster']).constant('AppConstants', {
      //'hostName':'http://192.168.1.5:8080/',
        'hostName':'http://127.0.0.1:8080/',
	   'get' : 'GET' ,  
	   'post' : 'POST' , 
	   'LanguageURL' : 'api/admin/setup/languages',
	   'GenresURL' : 'api/admin/setup/genres',
	   'DisplayMoviesURL' : 'api/display/movies',
	   'DisplayRecentURL' : 'api/display/recentMovies',
	   'MoviesAccordingToGenresURL' : 'api/display/moviesAccordingToGenres',
	   'MoviesAccordingToLangURL' : 'api/display/moviesAccordingToLanguage',
	   'PopularMoviesURL' : 'api/display/popularMovies',
	   'TopRatedMoviesURL' : 'api/display/topRatedMovies',
	   'UpComingMoviesURL' : 'api/display/upComingMovies',
	   'GetServiceRequestURL' : 'api/admin/setup/requestFacilityForStatus',
	   'GetAllFacilityiesURL' : 'api/admin/setup/facility',
	   'RequestFacilityURL' : 'api/admin/setup/requestFacility',
	   'MenuURL' : 'api/admin/resturant/menus',
	   'OrderURL' : 'api/admin/resturant/order',
	   'OrdersURL' : 'api/admin/resturant/orders',
	   'MenuTypesURL' : 'api/admin/resturant/menuTypes',
	   'MenuSingleURL' : 'api/admin/resturant/menu',
	   'OrderPlacedByUser':'api/admin/resturant/placedOrder',
		'OrderStatusUpdate':'api/admin/resturant/orderStatus',
		'OrdeExceptStatusURL':'api/admin/resturant/ordersExceptStatus'
		   
	}).directive('ngConfirmClick', [
	                                   function(){
	                                       return {
	                                           link: function (scope, element, attr) {
	                                               var msg = attr.ngConfirmClick || "Are you sure?";
	                                               var clickAction = attr.confirmedClick;
	                                               element.bind('click',function (event) {
	                                                   if ( window.confirm(msg) ) {
	                                                       scope.$eval(clickAction)
	                                                   }
	                                                   else{
	                                                	   
	                                                   }
	                                               });
	                                           }
	                                       };
	                               }]);
}());
