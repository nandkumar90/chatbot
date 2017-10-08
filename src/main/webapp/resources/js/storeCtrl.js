var app=angular.module('storeModule',['ngSanitize']);
app.controller('MainCtrl', ['$scope','mainService',function($scope, mainService) {
	  var data = {};
	  $scope.frameData=false;
		  $scope.setiFrame = function () {
			  $scope.frameData=true;
	    }
	  
		  $scope.setiFrameClose = function () {
			  $scope.frameData=false;
	    }
	  $scope.chats =[];
	  $scope.imgval=1;
	  $scope.sendMsg = function(){
		  $scope.imgval=1;
	    data.text = $scope.msg;
	    var chatObj = {
	      sender : 'human',
	      msg : $scope.msg
	    };
	    $scope.chats.push(chatObj);
	    mainService.sendMessage(data).then(function(successResponse){
	    	$scope.conversationId=successResponse.data.conversation_id;
	      $scope.chats.push(successResponse.data);
	      $scope.msg1= successResponse.data.msg;
	      //$scope.msg1=successResponse.data.msg.replace("<a ","<a ng-click=\"$event.preventDefault();$scope.setiFrame()\"");

	      
	      console.log("request passed");
	      $scope.msg='';
	      $scope.imgval=2;
	    },
	    function(errorResponse){
	      //show error message
	      console.log("request failed");
	    });
	  };
	  } ]).controller('formCtrl', function($scope, $http) {

			console.log("in form control");
			$scope.count = 0;

			$scope.genPDF = function() {
				 var print = function(location) {
			            console.log(location);
			          
			                HTML = document.getElementById("contact_form").innerHTML;
			         
			            var printPage = window.open('', '_blank', 'width=1400, height=800, scrollbars=yes, menubar=no, toolbar=no, location=no, status=no, titlebar=no');
			            printPage.document.open();
			            printPage.document.write('<html><head><link rel="stylesheet"/></head> <body onload="window.print()">' + HTML + '</body></html>');
			            printPage.document.close();
			        }
				 print();
			};
		});


	app.factory('mainService',
			  ['$http',
			   function($http
					   ) {
					     var factory={};
					     
					     factory.sendMessage = function(data) {
					       return $http({
	      	          method: 'POST',
	      	          data:data,
	      	          url: '/ePassportSeva/watson/message'
	      	      });
					     };
					     return factory;
					   }
					   ]);