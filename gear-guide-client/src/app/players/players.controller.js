export default class PlayersController {

    constructor(playersService) {
        'ngInject';

        this.playersService = playersService;
        this.players = playersService.getPlayers();
    }

}
