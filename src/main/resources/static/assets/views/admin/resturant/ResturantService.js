(function () {
	'use strict';
	angular.module('wifyApp').factory('ResturantService', ['$http','AppConstants',function ($http,AppConstants ){

		return {
			GetMenusTypes: function ($scope) {
				return  $http({
					method: 'GET',
					url:AppConstants.hostName+AppConstants.menuTypes,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : ''
				})
			},

			GetMenus: function ($scope) {
				return  $http({
					method: 'GET',
					url:AppConstants.hostName+AppConstants.MenuURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : ''
				})
			},	
			
			GetMenusForAvlType: function ($scope) {
				return  $http({
					method: 'GET',
					url:AppConstants.hostName+AppConstants.MenuURL+'/'+$scope.avlType,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : ''
				})
			},	
			SaveMenu: function ($scope) {
				return  $http({
					method: 'POST',
					url:AppConstants.hostName+AppConstants.MenuSingleURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : $scope.menu
				})
			},
			
			DeleteMenu: function ($scope) {
				return  $http({
					method: 'DELETE',
					url:AppConstants.hostName+AppConstants.MenuURL+'/'+$scope.menu.menuId,
					// url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : ''
				})
			},
			GetOrderDetails: function ($scope) {
				return  $http({
					method: 'GET',
					url:AppConstants.hostName+AppConstants.OrdersURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : ''
				})
			},	
			SaveOrderDetails: function ($scope) {
				return  $http({
					method: 'POST',
					url:AppConstants.hostName+AppConstants.OrderURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : $scope.menu
				})
			},
			DeleteOrderDetails: function ($scope) {
				return  $http({
					method: 'DELETE',
					url:AppConstants.hostName+AppConstants.OrderURL,
					// url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : ''
				})
			},
			
			PlacedOrderDetails: function ($scope) {
				return  $http({
					method: 'POST',
					url:AppConstants.hostName+AppConstants.OrderPlacedByUser,
					// url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : $scope.order
				})
			},
			GetOrderDetailsForStatus: function ($scope) {
				return  $http({
					method: 'GET',
					url:AppConstants.hostName+AppConstants.OrdersURL+"/"+$scope.status,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : ''
				})
			},	
			
			GetOrderDetailsForNotStatus: function ($scope) {
				return  $http({
					method: 'GET',
					url:AppConstants.hostName+AppConstants.OrdeExceptStatusURL+"/"+$scope.status,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : ''
				})
			},	
		}
	}]);
}());