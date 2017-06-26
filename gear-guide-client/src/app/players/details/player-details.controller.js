export default class PlayerDetailsController {

    constructor($stateParams, playerResource) {
        'ngInject';

        this.$stateParams = $stateParams;
        this.playerResource = playerResource;

        this.player = this.playerResource.getPlayer({id: this.$stateParams.id});
    }


}
