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
						$scope.orderStatusList=[{"name":"ORDER_RECIVED"},{"name":"IN_KITCHEN"},{"name":"DELAY"},{"name":"15min Waiting"},{"name":"10min Waiting"},{"name":"30min Waiting"},{"name":"Served"},{"name":"Paymet Recived"}];
						$scope.viewOrderDetails=true;
						$scope.viewMenuDetails=false;
						$scope.orderList=[];
						$scope.order={};
						$scope.adminfunctionDetails="Order Details";
						$scope.pedningOrderCount=0;
						
						$scope.nextOrders=0;
						$scope.previousOrders=0;
						
						$scope.nextMenus=0;
						$scope.previousMenus=0;
						
						
						$scope.getMenus= function() {
							$scope.viewOrderDetails=false;
							$scope.viewMenuDetails=true;
							
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
							$scope.adminfunctionDetails="Menu Details";
							$scope.viewOrderDetails=false;
							$scope.menu={};
						}
						
						$scope.saveMenu= function() {
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
						
						
						$scope.nextOrderDetails= function() {
							
						}
						$scope.previousOrderDetails= function() {
							
						}
						
						$scope.nextMenuDetails= function() {
							
						}
						$scope.previousMenuDetails= function() {
							
						}
						
						 
						var stompClient = null;
						$scope.connect = function ()  {
							if(null==stompClient){
							    var socket = new SockJS('/wify_hotel');
							    stompClient = Stomp.over(socket);
							}
				
						    stompClient.connect({}, function (frame) {
						        stompClient.subscribe('/topics/orderPlaced', function (data) {
						        	 $scope.orderList=JSON.parse(data.body);
						        	 $rootScope.$apply(); 
						        });
						    });
						}
						
						$scope.disconnect = function ()  {
						    if (stompClient !== null) {
						        stompClient.disconnect();
						    }
						    setConnected(false);
						    console.log("Disconnected");
						}
						$scope.connect();	
						
						$scope.status='';
						$scope.pendingOrderList=[];
						$scope.pendingOrderDetails= function ()  {
							$scope.status='PENDING';
							ResturantService.GetOrderDetailsForStatus($scope).then(function (result) {
								$scope.pendingOrderList=result.data;
								$scope.pedningOrderCount=$scope.pendingOrderList.length;
					    	},function (error){
					    		var errormsg='Unable to get languages';
								$exceptionHandler(errormsg);
					    	});
						}
						
						$scope.getOrderDetails= function ()  {
							$scope.status='PAID';
							ResturantService.GetOrderDetailsForNotStatus($scope).then(function (result) {
								$scope.orderList=result.data;
					    	},function (error){
					    		var errormsg='Unable to get languages';
								$exceptionHandler(errormsg);
					    	});
						}
						
					} ]);
}());