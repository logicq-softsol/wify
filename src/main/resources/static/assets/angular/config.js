/**
 * 
 */

(function() {
	'use strict';
	angular.module('wifyApp').config(
			[
					'$httpProvider',
					'$provide',
					function($httpProvider, $provide) {
						$provide.decorator("$exceptionHandler", function(
								$delegate, $injector) {
							return function(exception, cause) {
								var rootScope = $injector.get("$rootScope");
								$delegate(exception, cause);
							};
						});

					} ]);

}());