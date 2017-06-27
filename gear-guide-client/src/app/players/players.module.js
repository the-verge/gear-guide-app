const moduleName = 'app.players';

import PlayersController from './players.controller';
import PlayersService from './players.service';
import PlayerResource from './players.resource';
import PlayerDetailsController from './details/player-details.controller';
import PlayerDetailsService from './details/player-details.service';

angular.module(moduleName, [])
    .controller('playersController', PlayersController)
    .service('playersService', PlayersService)
    .factory('playerResource', PlayerResource)
    .controller('playerDetailsController', PlayerDetailsController)
    .service('playerDetailsService', PlayerDetailsService);

export default moduleName;