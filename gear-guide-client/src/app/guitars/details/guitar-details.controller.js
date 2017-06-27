export default class GuitarDetailsController {

    constructor($stateParams, guitarDetailsService) {
        'ngInject';

        this.guitarDetailsService = guitarDetailsService;
        this.guitar = this.guitarDetailsService.loadGuitar({id: $stateParams.id});
    }
}