

(function() {
	var thekaApplication = angular.module('theka', [ 'ui.router','storeModule']);
	

	
	thekaApplication.config(['$stateProvider', '$urlRouterProvider','$locationProvider',
		function($stateProvider, $urlRouterProvider,$locationProvider) {
			
			$stateProvider.state('home', {
				url: '/newform',
				templateUrl: 'resources/views/test.html',
				controller: 'formCtrl'

			});		

		}
	]);





	
			

	
})();
