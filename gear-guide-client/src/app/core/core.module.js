const moduleName = 'app.core';

angular.module(moduleName, [
    'ngResource',
    'ui.router',
    'ui.bootstrap',
    'ncy-angular-breadcrumb'
])
.constant('API_ROOT', '/api/');

export default moduleName;