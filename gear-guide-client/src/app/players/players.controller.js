export default class PlayerController {

    constructor(playerResource) {
        'ngInject';

        this.players = playerResource.get();
    }

}
