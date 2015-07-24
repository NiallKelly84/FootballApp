angular.module('resultsApp', ['ngRoute', 'nvd3', 'ngResource'])
.config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/results', {
    	controller: 'ResultsController',
        templateUrl: 'app/results/Results.html'
      });
}])