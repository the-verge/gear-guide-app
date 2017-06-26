const moduleName = 'app.guitars';

import GuitarDetailsController from './details/guitar-details.controller';
import GuitarResource from './guitars.resource';

angular.module(moduleName, [])
    .controller('guitarDetailsController', GuitarDetailsController)
    .factory('guitarResource', GuitarResource);

export default moduleName;