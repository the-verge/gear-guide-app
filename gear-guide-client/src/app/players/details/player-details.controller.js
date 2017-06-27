export default class PlayerDetailsController {

    constructor($stateParams, playerDetailsService) {
        'ngInject';

        this.playerDetailsService = playerDetailsService;
        this.loadPlayer($stateParams.id);
    }

    loadPlayer(id) {
        this.player = this.playerDetailsService.getPlayer(id);
    }

}
