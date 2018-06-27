(function () {
	'use strict';
	angular.module('wifyApp').factory('GenersService', ['$http','AppConstants',function ($http,AppConstants ){

		return {

			GetAllGenres: function ($scope) {

				return  $http({
					method: 'GET',
					url:AppConstants.hostName+AppConstants.GenresURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : ''
				})
			},	
			
			UpdateGenres: function ($scope) {
				return  $http({
					method: 'PUT',
					url:AppConstants.hostName+AppConstants.GenresURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : $scope.genres
				})
			},
			CreateGenres: function ($scope) {
				return  $http({
					method: 'POST',
					url:AppConstants.hostName+AppConstants.GenresURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : $scope.genres
				})
			},
			
			DeleteGenres: function ($scope) {
				return  $http({
					method: 'DELETE',
					url:AppConstants.hostName+AppConstants.GenresURL+'/'+$scope.genrId,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : ''
				})
			},
		}
	}]);
}());