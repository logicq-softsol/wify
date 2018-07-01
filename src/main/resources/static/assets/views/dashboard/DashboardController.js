(function() {
	'use strict';
	angular.module('wifyApp').controller(
			'DashboardController',
			[
					'$scope',
					'$rootScope',
					'$location',
					'$interval',
					'$exceptionHandler',
					'GenersService',
					'LanguageService',
					'DashboardService',
					'RecentService',
					'AdminService',
					'$sce',
					'ResturantService',
					function($scope, $rootScope, $location, $interval,
							$exceptionHandler,GenersService,LanguageService,DashboardService,RecentService,AdminService,$sce,ResturantService) {
						$scope.discoverHeader=false;
						$scope.discoverRecentMovis=true;
						$scope.playMoviSection=true;
						$scope.moviCategoryDetails=true;
						$scope.moviSpecificeDetails=true;
						
						$scope.genreslist = [];
						$scope.langlist = [];
						$scope.moviesList = [];
						$scope.videos=[];
						$scope.homeTab='active';
						$scope.moviTab='';
						$scope.moviGenerTab='';
						$scope.recentMovies=[];
						$scope.popularMovies=[];
						$scope.topMovies=[];
						$scope.upComingMovies=[];
						$scope.moviSearchContext=' ';
						$scope.ticketCount=[1,2,3,4,5,6,7,8,9,10];
						$scope.facilitiesList=[];
						$scope.viewsoftwaerspanel=true;
						$scope.menuTypes=[];
						
						$scope.viewSoftwares=function(){
							$scope.viewsoftwaerspanel=false;
							$scope.discoverHeader=true;
							$scope.discoverRecentMovis=true;
							$scope.playMoviSection=true;
							$scope.moviCategoryDetails=true;
							$scope.moviSpecificeDetails=true;
							$scope.orderNotification=false;
						}
						
						$scope.tabClick=function (value) {
							$scope.viewsoftwaerspanel=true;
							 $scope.video={};
							 $scope.setVideo();
							if('HOME'==value){
								$scope.moviSearchContext=' ';
								$scope.homeTab='active';
								$scope.moviTab='';
								$scope.moviGenerTab='';
								$scope.discoverHeader=true;
							    $scope.discoverRecentMovis=false;
								$scope.playMoviSection=true;
								$scope.moviCategoryDetails=false;
								$scope.moviSpecificeDetails=true;
								$scope.getAllRecentMovies();
							}else if('LANG'==value){
								$scope.homeTab='';
								$scope.moviTab='active';
								$scope.moviGenerTab='';
				
							}else{
								$scope.homeTab='';
								$scope.moviTab='';
								$scope.moviGenerTab='active';
							
							}
						}
						
						 $scope.getAllRecentMovies = function () {
						    	RecentService.GetRecentMovies($scope).then(function (response) {
						    		 $scope.recentMovies=response.data;
						    	},function (error){
						    		var errormsg='Unable to fetch Recent movies ';
									$exceptionHandler(errormsg);
						    	});
							 }
						
						 $scope.getAllGenres = function () {
							 GenersService.GetAllGenres($scope) .then(function (result) {
								 $scope.genreslist = result.data;
						        }, function(result) {
						        	var errormsg='Unable to get Generes';
									$exceptionHandler(errormsg);
						        });
						    }
						 
						 
						 $scope.getAllLanguages = function () {
						 LanguageService.GetAllLanguages($scope).then(function (result) {
								 $scope.langlist = result.data;
						    	},function (error){
						    		var errormsg='Unable to get languages';
									$exceptionHandler(errormsg);
						    	});
						    }
						 
						 $scope.eachGenreSelect =function (gener) {
							    $scope.discoverHeader=true;
								$scope.discoverRecentMovis=true;
								$scope.playMoviSection=true;
								$scope.moviCategoryDetails=true;
								$scope.moviSpecificeDetails=false;
								$scope.orderNotification=false;
							   $scope.genres=gener.name;
							 $scope.moviSearchContext=" Selected Genres : "+gener.name;
							 DashboardService.GetMoviesAccordingToGenres($scope).then(function(result){
								 $scope.moviesList=result.data;
							     }, function(result) {
						        	var errormsg='Unable to get Generes';
									$exceptionHandler(errormsg);
						        });
						 }
						 
						 $scope.eachLangSelect =function (lang) {
							    $scope.discoverHeader=true;
								$scope.discoverRecentMovis=true;
								$scope.playMoviSection=true;
								$scope.moviCategoryDetails=true;
								$scope.moviSpecificeDetails=false;
							    $scope.lang=lang.name;
							    $scope.moviSearchContext=" Selected Language : "+lang.name;
							 DashboardService.GetMoviesAccordingToLanguage($scope).then(function(result){
								 $scope.moviesList=result.data;
							     }, function(result) {
						        	var errormsg='Unable to get Generes';
									$exceptionHandler(errormsg);
						        });
						 }
						 
					
					
						 $scope.onClickDiscoverNow = function () {
							$scope.discoverHeader=true;
							$scope.discoverRecentMovis=false;
							$scope.playMoviSection=true;
							$scope.moviCategoryDetails=false;
							$scope.moviSpecificeDetails=true;
							$scope.getAllRecentMovies();
						 }
						 
						 $scope.video={};
						 $scope.playedmovi={};
						 $scope.playMovi =function (movi) {
							 
								$scope.discoverHeader=true;
								$scope.discoverRecentMovis=true;
								$scope.moviCategoryDetails=true;
								$scope.moviSpecificeDetails=true;
							    $scope.playMoviSection=false;
							    $scope.orderNotification=false;
		
							 $scope.playedmovi=movi;
								$scope.video = { sources: [{src: $sce.trustAsResourceUrl(movi.movisource), type: "video/mp4"}],
										theme: {
										      url: "assets/html/css/videogular.css"
										    },
										   plugins: {
												poster: movi.poster_url
											}
						   };
							$('#advPopup').modal('show');
						 }
						 
						 $scope.popularMovi=function () {
							 DashboardService.PopularMovies($scope).then(function (result) {
								 $scope.popularMovies = result.data;
						    	},function (error){
						    		var errormsg='Unable to get languages';
									$exceptionHandler(errormsg);
						    	});
						    }
						 
						 $scope.topRatedMovi=function () {
							 DashboardService.PopularMovies($scope).then(function (result) {
								 $scope.topMovies = result.data;
						    	},function (error){
						    		var errormsg='Unable to get languages';
									$exceptionHandler(errormsg);
						    	});
						    }
						 
						 $scope.upComingMovi=function () {
							 DashboardService.PopularMovies($scope).then(function (result) {
								 $scope.upComingMovies = result.data;
						    	},function (error){
						    		var errormsg='Unable to get languages';
									$exceptionHandler(errormsg);
						    	});
						    }
						 
						   $scope.API = null;
				            $scope.onPlayerReady = function(API) {
				            	$scope.API = API;
				            };  
						 
				            
				            $scope.setVideo = function() {
				            	if(null!=$scope.API){
				            		$scope.API.stop();
				            	}
				            };  
				           
				            $scope.onClickTicketCount = function(ticket) {
				            	  console.log('This is your event now: '+ticket);
				            	};
				            	
				            	$scope.facilityName='';
				            	$scope.facilityRequest={};
								$scope.getFacilities = function() {
									AdminService.GetFacilites($scope).then(function (result) {
										 $scope.facilitiesList = result.data;
								    	},function (error){
								    		var errormsg='Unable to get languages';
											$exceptionHandler(errormsg);
								    	});
								}	
								
								$scope.RequestFacilityService = function(facility) {
									AdminService.RquestFacility($scope).then(function (result) {
										
							    	},function (error){
							    		var errormsg='Unable to get languages';
										$exceptionHandler(errormsg);
							    	});
								}
								
								
								//Menu Related 
								$scope.menuTypeList=[{"name":"Breakfast"},{"name":"Lunch"},{"name":"Dinner"},{"name":"Brunch"},{"name":"Snaks/Tapas"}];
								$scope.isBreakfast=true;
								$scope.isLunch=true;
								$scope.isDinner=true;
								$scope.isSnaks=true;
								$scope.isOffers=true;
								
								$scope.breakfastMenuList=[];
								$scope.lunchMenuList=[];
								$scope.dinnerMenuList=[];
								$scope.snaksMenuList=[];
								$scope.offersMenuList=[];
								$scope.avlType=null;
								
								 $scope.viewResturantMenus=true;
						            $scope.viewResturnatMenus= function(){
						            	$scope.viewResturantMenus=false;
						            	$scope.discoverHeader=true;
									    $scope.discoverRecentMovis=true;
										$scope.playMoviSection=true;
										$scope.moviCategoryDetails=true;
										$scope.moviSpecificeDetails=true;
										$scope.orderNotification=false;
									//	$scope.getMenus(null);
						            }
						            	
								
						        	$scope.getBreakfastMenus= function() {
						        		$scope.avlType='Breakfast';
						        		ResturantService.GetMenusForAvlType($scope).then(function (result) {
						        			$scope.breakfastMenuList=[];
						        			$scope.breakfastMenuList=result.data;
						        			 angular.forEach($scope.breakfastMenuList, function(value, key){
						        			      if(value.category == "VEG")
						        			    	  value["categoryimg"]='assets/html/img/foodtype/icon-veg.png';
						        			      else
						        			    	  value["categoryimg"]='assets/html/img/foodtype/icon-non-veg.png';
						        			   });
						        		},function (error){
								    		var errormsg='Unable to get languages';
											$exceptionHandler(errormsg);
								    	});
						        		}
						        	
						        	$scope.getLunchMenus= function() {
						        		$scope.avlType='Lunch';
						        		ResturantService.GetMenusForAvlType($scope).then(function (result) {
						        			$scope.lunchMenuList=[];
						        			$scope.lunchMenuList=result.data;
						        			angular.forEach($scope.lunchMenuList, function(value, key){
						        			      if(value.category == "VEG")
						        			    	  value["categoryimg"]='assets/html/img/foodtype/icon-veg.png';
						        			      else
						        			    	  value["categoryimg"]='assets/html/img/foodtype/icon-non-veg.png';
						        			   });
						        		},function (error){
								    		var errormsg='Unable to get languages';
											$exceptionHandler(errormsg);
								    	});
						        		}
						        	
						        	
						        	$scope.getDinnerMenus= function() {
						        		$scope.avlType='Dinner';
						        		ResturantService.GetMenusForAvlType($scope).then(function (result) {
						        			$scope.dinnerMenuList=[];
						        			$scope.dinnerMenuList=result.data;
						        			angular.forEach($scope.dinnerMenuList, function(value, key){
						        			      if(value.category == "VEG")
						        			    	  value["categoryimg"]='assets/html/img/foodtype/icon-veg.png';
						        			      else
						        			    	  value["categoryimg"]='assets/html/img/foodtype/icon-non-veg.png';
						        			   });
						        		},function (error){
								    		var errormsg='Unable to get languages';
											$exceptionHandler(errormsg);
								    	});
						        		}
						        	
						        	
						        	$scope.getSnaksMenus= function() {
						        		$scope.avlType='Snaks';
						        		ResturantService.GetMenusForAvlType($scope).then(function (result) {
						        			$scope.snaksMenuList=[];
						        			$scope.snaksMenuList=result.data;
						        			angular.forEach($scope.snaksMenuList, function(value, key){
						        			      if(value.category == "VEG")
						        			    	  value["categoryimg"]='assets/html/img/foodtype/icon-veg.png';
						        			      else
						        			    	  value["categoryimg"]='assets/html/img/foodtype/icon-non-veg.png';
						        			   });
						        		},function (error){
								    		var errormsg='Unable to get languages';
											$exceptionHandler(errormsg);
								    	});
						        		}
						        	
						        	$scope.getOffersMenus= function() {
						        		$scope.avlType='Offers';
						        		ResturantService.GetMenusForAvlType($scope).then(function (result) {
						        			$scope.offersMenuList=[];
						        			$scope.offersMenuList=result.data;
						        			angular.forEach($scope.offersMenuList, function(value, key){
						        			      if(value.category == "VEG")
						        			    	  value["categoryimg"]='assets/html/img/foodtype/icon-veg.png';
						        			      else
						        			    	  value["categoryimg"]='assets/html/img/foodtype/icon-non-veg.png';
						        			   });
						        		},function (error){
								    		var errormsg='Unable to get languages';
											$exceptionHandler(errormsg);
								    	});
						        		}
						        	
						        	$scope.cartlist=[];
									$scope.totalprice=0;
									$scope.totalquantity=0;
									$scope.order={};
						        	$scope.addToCart= function(menu) {
						        		
						        		var index = $scope.findMenuIndex(menu);
						        		if(index==-1){
						        			$scope.cart={};
						        			$scope.cart["menuId"]=menu.menuId;
							        		$scope.cart["itemName"]=menu.name;
							        		$scope.cart["category"]=menu.category;
							        		$scope.cart["price"]=menu.price;
							        		$scope.cart["quantity"]=1;
							        		$scope.cart["totalMenuPrice"]=$scope.cart["quantity"]*menu.price;
							        		$scope.totalprice=$scope.totalprice+menu.price;
							        		$scope.totalquantity=$scope.totalquantity+1;
							        		  if(menu.category == "VEG")
							        			  $scope.cart["categoryimg"]='assets/html/img/foodtype/icon-veg.png';
					        			      else
					        			    	  $scope.cart["categoryimg"]='assets/html/img/foodtype/icon-non-veg.png';
							        		  $scope.cartlist.push($scope.cart);
						        		}else{
						        			var value=$scope.cartlist[index];
							        		if(null!=value){
							        			if(value.menuId==menu.menuId){
								        			value["quantity"]+=1;
								        			value["totalMenuPrice"]=value["quantity"]*menu.price;
								        			$scope.totalprice+=menu.price;
								        			$scope.totalquantity+=1;
								        	    }
							        		}
						        		}
						        		
	
						        	}
						        	
						        
						        	
						        	$scope.cartQuantityAdd= function(menu) {
						        		var index = $scope.findMenuIndex(menu);
						        		var value=$scope.cartlist[index];
						        		if(null!=value){
						        			if(value.menuId==menu.menuId){
							        			value["quantity"]+=1;
							        			value["totalMenuPrice"]=value["quantity"]*menu.price;
							        			$scope.totalprice+=menu.price;
							        			$scope.totalquantity+=1;
							        	    }
						        		}
						        		//$rootScope.$apply(); 
						        	}
						        	
						        	
						        	$scope.removeFromCart= function(menu) {
						        		var index = $scope.findMenuIndex(menu);
						        		var value=$scope.cartlist[index];
						        		if(null!=value && value["quantity"]>1){
						        			if(value.menuId==menu.menuId){
							        			value["quantity"]-=1;
							        			value["totalMenuPrice"]=value["quantity"]*menu.price;
							        			$scope.totalprice-=menu.price;
							        			$scope.totalquantity-=1;
							        	    }
						        		}else{
						        			$scope.cartlist.splice(index,1);
						        			$scope.totalprice-=menu.price;
						        			$scope.totalquantity-=1;
						        		}
					        			//$rootScope.$apply(); 
						        	}
						        	
						        	$scope.reviewOrderpanel=false;
						        	$scope.reviewOrderDetails = function() {
						        		$scope.reviewOrderpanel=true;
						        		$scope.viewResturantMenus=true;
						            	$scope.discoverHeader=true;
									    $scope.discoverRecentMovis=true;
										$scope.playMoviSection=true;
										$scope.moviCategoryDetails=true;
										$scope.moviSpecificeDetails=true;
										$scope.orderNotification=false;
						        	}

						        	$scope.confirmOrder= function() {
						     
						        		$scope.order.orderStatus="ORDER_RECIVED";
						        		$scope.order.orderTime=new Date();
						        		$scope.order.totalPrice=$scope.totalprice;
						        		$scope.order.menuDetails=$scope.cartlist;
						        		ResturantService.PlacedOrderDetails($scope).then(function (result) {
						        			$scope.viewsoftwaerspanel=true;
											$scope.discoverHeader=true;
											$scope.discoverRecentMovis=true;
											$scope.playMoviSection=true;
											$scope.moviCategoryDetails=true;
											$scope.moviSpecificeDetails=true;
											$scope.viewResturantMenus=true;
											$scope.reviewOrderpanel=false;
							        		$scope.orderNotification=true;
							        		
							        		$scope.conformOrderlist=result.data;
							        		//$scope.ordertotalprice=$scope.totalprice;
						        		},function (error){
								    		var errormsg='Unable to get languages';
											$exceptionHandler(errormsg);
								    	});
						        		
						        		
						        	}
						        	$scope.closeOrder= function() {
						        		$scope.order={};
						        	}
						        	
						        	$scope.addMoreMenuDetails= function() {
						        		$scope.viewResturantMenus=false;
						            	$scope.discoverHeader=true;
									    $scope.discoverRecentMovis=true;
										$scope.playMoviSection=true;
										$scope.moviCategoryDetails=true;
										$scope.moviSpecificeDetails=true;
										$scope.reviewOrderpanel=false;
										$scope.orderNotification=false;
						        	}
						        	$scope.viewCustomerOrderDetails= function() {
						        		$scope.viewsoftwaerspanel=true;
										$scope.discoverHeader=true;
										$scope.discoverRecentMovis=true;
										$scope.playMoviSection=true;
										$scope.moviCategoryDetails=true;
										$scope.moviSpecificeDetails=true;
										$scope.viewResturantMenus=true;
										$scope.reviewOrderpanel=false;
						        		$scope.orderNotification=true;
						        	}
						        	
								
						        	//Find index of element 
						        	$scope.findMenuIndex = function(menu){
						        		  for(var i = 0; i < $scope.cartlist.length; i++){
							        	        if(angular.equals($scope.cartlist[i].menuId, menu.menuId)){
							        	            return i;
							        	        }
							        	    };
							        	    return -1;
						        	}
						        
								
					} ]);
}());