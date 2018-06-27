(function() {
	'use strict';
	angular.module('wifyApp').controller(
			'AdminController',
			[
					'$scope',
					'$rootScope',
					'$location',
					'$interval',
					'$exceptionHandler',
					'AdminService',
					'ResturantService',
					function($scope, $rootScope, $location, $interval,$exceptionHandler,AdminService,ResturantService) {
						$scope.serviceList=[];
						$scope.bookedTicketList=[];
						$scope.facilitiesList=[];
						$scope.menuTypeList=[{"name":"COMBO"},{"name":"NORMAL"}];
						$scope.menuAvlList=[{"name":"Breakfast"},{"name":"Lunch"},{"name":"Dinner"},{"name":"Snaks/Tapas"},{"name":"All"}];
						$scope.menuCatList=[{"name":"VEG"},{"name":"NON-VEG"},{"name":"SWEETS"},{"name":"DRINKS"}];
						$scope.menuList=[];
						$scope.menu={};
						$scope.orderStatusList=[{"name":"Recent"},{"name":"InKitchen"},{"name":"Delay"},{"name":"15min Waiting"},{"name":"10min Waiting"},{"name":"30min Waiting"},{"name":"Served"},{"name":"Paymet Recived"}];
						$scope.viewOrderDetails=false;
						$scope.orderList=[];
						$scope.order={};
						
						$scope.getMenus= function() {
							ResturantService.GetMenus($scope).then(function (result) {
								$scope.menuList=result.data;
					    	},function (error){
					    		var errormsg='Unable to get languages';
								$exceptionHandler(errormsg);
					    	});
						}
						
						$scope.eachMenu= function(menu) {
							$scope.menu=menu;
						}
						$scope.addMenu= function(menu) {
							$scope.viewOrderDetails=false;
							$scope.menu={};
						}
						
						$scope.saveMenu= function() {
							$scope.viewOrderDetails=false;
							ResturantService.SaveMenu($scope).then(function (result) {
								$scope.menuList=result.data;
					    	},function (error){
					    		var errormsg='Unable to get languages';
								$exceptionHandler(errormsg);
					    	});
						}
						$scope.deleteMenu= function() {
							ResturantService.DeleteMenu($scope).then(function (result) {
								$scope.menuList=result.data;
					    	},function (error){
					    		var errormsg='Unable to get languages';
								$exceptionHandler(errormsg);
					    	});
						}
						
						$scope.orderDetails= function() {
							$scope.viewOrderDetails=true;
							$scope.getOrderDetails();
						}
						
						$scope.getOrderDetails= function() {
							
							ResturantService.GetOrderDetails($scope).then(function (result) {
								$scope.orderList=result.data;
					    	},function (error){
					    		var errormsg='Unable to get languages';
								$exceptionHandler(errormsg);
					    	});
						}
						
						$scope.eachOrder= function(order) {
							$scope.order=order;
						}
						
						$scope.updateOrder= function() {
							ResturantService.UpdateOrderDetails($scope).then(function (result) {
								$scope.orderList=result.data;
					    	},function (error){
					    		var errormsg='Unable to get languages';
								$exceptionHandler(errormsg);
					    	});
						}
						$scope.deleteOrder= function() {
							ResturantService.DeleteOrderDetails($scope).then(function (result) {
								$scope.orderList=result.data;
					    	},function (error){
					    		var errormsg='Unable to get languages';
								$exceptionHandler(errormsg);
					    	});
						}
						
					} ]);
}());