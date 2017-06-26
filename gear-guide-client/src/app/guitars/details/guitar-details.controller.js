export default class GuitarDetailsController {

    constructor($stateParams, guitarResource) {
        'ngInject';

        this.$stateParams = $stateParams;
        this.guitarResource = guitarResource;

        this.guitar = this.guitarResource.getGuitar({id: this.$stateParams.id});
    }
}