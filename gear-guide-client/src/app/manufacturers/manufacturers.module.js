const moduleName = 'app.manufacturers';

import ManufacturersResource from './manufacturers.resource';
import ManufacturersService from './manufacturers.service';

angular.module(moduleName, [])
    .factory('manufacturersResource', ManufacturersResource)
    .service('manufacturersService', ManufacturersService);

export default moduleName;
