(function() {

	angular.module('wifyApp').config(
			function($stateProvider, $urlRouterProvider) {
				$urlRouterProvider.otherwise("/dash");
				$stateProvider.state('dash', {
					url : "/dash",
					templateUrl : "assets/views/dashboard/dashboard.html",
					controller : 'DashboardController'
				}),
				$stateProvider.state('admin', {
					url : "/admin",
					templateUrl : "assets/views/admin/admin.html",
					controller : 'AdminController'
				}),
				$stateProvider.state('menu', {
					url : "/menu",
					templateUrl : "assets/views/admin/menu.html",
					controller : 'AdminController'
				})
			});
})();