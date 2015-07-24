angular
    .module('resultsApp')
    .service('ResultsService', ResultsService);

function ResultsService(ResultFactory) {

    this.getResultsList = getResultsList;

    function getResultsList(teamA, teamB, callback) {
        return ResultFactory.get({teamA: teamA, teamB: teamB}, callback);
    }
}
