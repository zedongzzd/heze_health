var path = require('path')
var webpack = require('webpack')
// var commonsPlugin = new webpack.optimize.CommonsChunkPlugin('common.js');

module.exports = {

  entry: [
    'webpack-hot-middleware/client',
    './js/index'
  ],
  output: {
    path: path.join(__dirname, 'dist'),
    filename: 'bundle.js',
    publicPath: '/static/'
  },
  plugins: [
    new webpack.optimize.OccurenceOrderPlugin(),
    new webpack.HotModuleReplacementPlugin(),
    new webpack.NoErrorsPlugin(),
  //   new webpack.DefinePlugin({
  //   'process.env.NODE_ENV': '"production"'
  //   }),
  //   new webpack.optimize.UglifyJsPlugin({
  //    compress: {
  //      //supresses warnings, usually from module minification
  //      warnings: false
  //    }
  //  }),
  ],
  module: {
    loaders: [
      {
        test: /\.js$/,
        loaders: [ 'babel' ],
        exclude: /node_modules/,
        include: __dirname
      },
      {test: /\.scss$/, loader: "style!css!sass"}
    ]
  }
}


// When inside Redux repo, prefer src to compiled version.
// You can safely delete these lines in your project.
var reduxSrc = path.join(__dirname, '..', '..', 'src')
var reduxNodeModules = path.join(__dirname, '..', '..', 'node_modules')
var fs = require('fs')
if (fs.existsSync(reduxSrc) && fs.existsSync(reduxNodeModules)) {
  // Resolve Redux to source
  module.exports.resolve = { alias: { 'redux': reduxSrc } }
  // Our root .babelrc needs this flag for CommonJS output
  process.env.BABEL_ENV = 'commonjs'
  // Compile Redux from source
  module.exports.module.loaders.push({
    test: /\.js$/,
    loaders: [ 'babel' ],
    include: reduxSrc
  })
}
