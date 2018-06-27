(function () {
	'use strict';
	angular.module('wifyApp').factory('AdminService', ['$http','AppConstants',function ($http,AppConstants ){

		return {
			GetFacilites: function ($scope) {

				return  $http({
					method: 'GET',
					url:AppConstants.hostName+AppConstants.DisplayMoviesURL,
					// url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : ''
				})
			},

			GetBookedTicketList: function ($scope) {

				return  $http({
					method: 'GET',
					url:AppConstants.hostName+AppConstants.DisplayMoviesURL,
					// url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : ''
				})
			},	
			GetServiceRequestList: function ($scope) {
			return  $http({
				method: 'GET',
				url:AppConstants.hostName+AppConstants.GetAllFacilityiesURL,
				// url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
				headers: {'Content-Type': 'application/json'} ,
				dataType :'json',
				data : ''
			})
		},
		RquestFacility: function ($scope) {
			return  $http({
				method: 'PUT',
				url:AppConstants.hostName+AppConstants.RequestFacilityURL,
				headers: {'Content-Type': 'application/json'} ,
				dataType :'json',
				data : $scope.facility
			})
		},
		}
	}]);
}());