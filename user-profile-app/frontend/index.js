try {
  const fsevents = require('fsevents');
  const watcher = fsevents.watch(__dirname, (path, flags, id) => {
    const info = fsevents.getInfo(path, flags, id);
    console.log('File change:', info);
  });
  console.log('Watching for file changes...');
} catch (e) {
  console.log('fsevents only works on macOS.');
}