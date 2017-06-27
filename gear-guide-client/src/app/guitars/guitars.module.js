const moduleName = 'app.guitars';

import GuitarDetailsController from './details/guitar-details.controller';
import GuitarDetailsService from './details/guitar-details.service';
import GuitarsResource from './guitars.resource';

angular.module(moduleName, [])
    .controller('guitarDetailsController', GuitarDetailsController)
    .service('guitarDetailsService', GuitarDetailsService)
    .factory('guitarsResource', GuitarsResource);

export default moduleName;