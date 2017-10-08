var thekaApplication = angular.module('customDirective',[]);

thekaApplication.directive('parseHtml',['$compile',function ($compile) {
	return function(scope, element, attrs) {

	    scope.$watch(
	      function(scope) {

	        return scope.$eval(attrs.compile);
	      },
	      function(value) {
	        console.log(value) 
	        // Here you can see your HTML is going to get sanitized below
	        element.html(value); 
	        $compile(element.contents())(scope); // After this HTML will be sanitized.

	      }
	 )};
	}])