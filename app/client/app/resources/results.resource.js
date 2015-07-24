angular
    .module('resultsApp')
    .factory('ResultFactory', ResultFactory);

function ResultFactory($resource) {
    return $resource('api/results', {}, {
            get: {method: 'get', isArray: true}
        });
}
