(function () {
	'use strict';
	angular.module('wifyApp').factory('DashboardService', ['$http','AppConstants',function ($http,AppConstants ){

		return {

			GetMoviesAccordingToCategory: function ($scope) {

				return  $http({
					method: 'GET',
					url:AppConstants.hostName+AppConstants.DisplayMoviesURL+'/'+$scope.category,
					// url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : ''
				})
			},	
			PopularMovies: function ($scope) {
			return  $http({
				method: 'GET',
				url:AppConstants.hostName+AppConstants.PopularMoviesURL,
				// url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
				headers: {'Content-Type': 'application/json'} ,
				dataType :'json',
				data : ''
			})
		},	
		TopRatedMovies: function ($scope) {
		return  $http({
			method: 'GET',
			url:AppConstants.hostName+AppConstants.TopRatedMoviesURL,
			// url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
			headers: {'Content-Type': 'application/json'} ,
			dataType :'json',
			data : ''
		})
	},	
	UpComingMovies: function ($scope) {
	return  $http({
		method: 'GET',
		url:AppConstants.hostName+AppConstants.UpComingMoviesURL,
		// url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
		headers: {'Content-Type': 'application/json'} ,
		dataType :'json',
		data : ''
	})
},	
			GetMoviesAccordingToGenres: function ($scope) {

				return  $http({
					method: 'GET',
					url:AppConstants.hostName+AppConstants.MoviesAccordingToGenresURL+'/'+$scope.genres,
					// url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : ''
				})
			},	
			GetMoviesAccordingToLanguage: function ($scope) {
				return  $http({
					method: 'GET',
					url:AppConstants.hostName+AppConstants.MoviesAccordingToLangURL+'/'+$scope.lang,
					// url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : ''
				})
			},	
			
			
			UpdateMovies: function ($scope) {
				return  $http({
					method: 'PUT',
					url:AppConstants.hostName+AppConstants.DisplayMoviesURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : $scope.movies
				})
			},
			CreateMovies: function ($scope) {
				return  $http({
					method: 'POST',
					url:AppConstants.hostName+AppConstants.DisplayMoviesURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : $scope.movies
				})
			},
			
			DeleteMovies: function ($scope) {
				return  $http({
					method: 'DELETE',
					url:AppConstants.hostName+AppConstants.GenresURL+'/'+$scope.moviId,
					// url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : ''
				})
			},
			
		}
	}]);
}());