const moduleName = 'app.core';

angular.module(moduleName, [
    'ngResource',
    'ui.router',
    'ui.bootstrap'
])
.constant('API_ROOT', '/api/');

export default moduleName;