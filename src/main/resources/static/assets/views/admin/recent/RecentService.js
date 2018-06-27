(function () {
	'use strict';
	angular.module('wifyApp').factory('RecentService', ['$http','AppConstants',function ($http,AppConstants ){

		return {

			GetRecentMovies: function ($scope) {

				return  $http({
					method: 'GET',
					url:AppConstants.hostName+AppConstants.DisplayRecentURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : ''
				})
			},	
		}
	}]);
}());