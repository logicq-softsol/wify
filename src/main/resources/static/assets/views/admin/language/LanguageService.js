(function () {
	'use strict';
	angular.module('wifyApp').factory('LanguageService', ['$http','AppConstants',function ($http,AppConstants ){

		return {

			GetAllLanguages: function ($scope) {

				return  $http({
					method: 'GET',
					url:AppConstants.hostName+AppConstants.LanguageURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : ''
				})
			},	
			
			UpdateLanguage: function ($scope) {
				return  $http({
					method: 'PUT',
					url:AppConstants.hostName+AppConstants.LanguageURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : $scope.lang
				})
			},
			CreateLanguage: function ($scope) {
				return  $http({
					method: 'POST',
					url:AppConstants.hostName+AppConstants.LanguageURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : $scope.lang
				})
			},
			
			DeleteLanguage: function ($scope) {
				return  $http({
					method: 'DELETE',
					url:AppConstants.hostName+AppConstants.LanguageURL+'/'+$scope.langId,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : ''
				})
			},
			
		}
	}]);
}());