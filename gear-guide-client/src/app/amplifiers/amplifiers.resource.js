export default ($resource, API_ROOT) => {
    'ngInject';

    return $resource(API_ROOT + 'amplifiers/:id', {id: '@id'}, {
        get: {
            method: 'get',
            timeout: 10000,
            isArray: true
        },

        getAmplifier: {
            url: API_ROOT + 'amplifiers/:id',
            method: 'get',
            timeout: 10000
        }
    });
};