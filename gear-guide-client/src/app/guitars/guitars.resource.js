export default ($resource, API_ROOT) => {
    'ngInject';

    return $resource(API_ROOT + 'guitars/:id', {id: '@id'}, {
        get: {
            method: 'get',
            timeout: 10000,
            isArray: true
        },

        getGuitar: {
            url: API_ROOT + 'guitars/:id',
            method: 'get',
            timeout: 10000
        }
    });
};