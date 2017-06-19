const moduleName = 'app.player';

import PlayerController from './players.controller';
import PlayerResource from './players.resource';
import PlayerDetailsController from './details/player-details.controller';

angular.module(moduleName, [])
    .controller('playerController', PlayerController)
    .factory('Player', PlayerResource)
    .controller('playerDetailsController', PlayerDetailsController);

export default moduleName;