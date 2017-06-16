module.exports = function(config) {
  config.set({

      basePath: '',
      frameworks: ['browserify', 'jasmine'],

      browsers: ['PhantomJS'],

      files: [
          './bower_components/angular/angular.js',
          './bower_components/angular-resource/angular-resource.js',
          './bower_components/angular-ui-router/release/angular-ui-router.js',
          './bower_components/angular-mocks/angular-mocks.js',
          './src/**/*.js',
          './test/**/*.js',
      ],

      exclude: [
      ],

      preprocessors: {
          'src/**/*.js': ['browserify'],
          'test/**/*.js': ['browserify']
      },

      browserify: {
          debug: true,
          transform: ['babelify']
      },

      logLevel: config.LOG_DEBUG

  });
};