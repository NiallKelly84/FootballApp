angular
    .module('resultsApp')
    .controller('ResultsController', ResultsController);

function ResultsController($scope, ResultsService) {

  $scope.list1 = {title: 'AngularJS - Drag Me'};
  $scope.list2 = {};
  $scope.teams = [{teamA: ''}, {teamB: ''}];
  $scope.premResults = [];

  $scope.searchByTeams = function () {
    ResultsService.getResultsList($scope.teams.teamA, $scope.teams.teamB, function (res) {
      $scope.premResults = res;
    });
  };
}