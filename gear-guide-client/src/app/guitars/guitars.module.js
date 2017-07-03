const moduleName = 'app.guitars';

import GuitarDetailsController from './details/guitar-details.controller';
import GuitarDetailsService from './details/guitar-details.service';
import GuitarsResource from './guitars.resource';
import GuitarsService from './guitars.service';

angular.module(moduleName, [])
    .controller('guitarDetailsController', GuitarDetailsController)
    .service('guitarDetailsService', GuitarDetailsService)
    .factory('guitarsResource', GuitarsResource)
    .service('guitarsService', GuitarsService);

export default moduleName;