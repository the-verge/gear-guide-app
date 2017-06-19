export default class PlayerDetailsController {

    constructor($stateParams, Player) {
        'ngInject';

        this.$stateParams = $stateParams;
        this.player = Player.getPlayer({id: this.$stateParams.id});
    }


}
