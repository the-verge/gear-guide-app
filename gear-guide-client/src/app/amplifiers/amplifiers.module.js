const moduleName = 'app.amplifiers';

import AmplifiersResource from './amplifiers.resource';
import AmplifiersService from './amplifiers.service';

angular.module(moduleName, [])
    .factory('amplifiersResource', AmplifiersResource)
    .service('amplifiersService', AmplifiersService);

export default moduleName;