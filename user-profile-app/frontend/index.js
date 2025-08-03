
try {
  const fsevents = require('fsevents');
  const watcher = fsevents.watch(__dirname, (path, flags, id) => {
    const info = fsevents.getInfo(path, flags, id);
    console.log('File change:', info);
  });
  console.log('fsevents loaded...');
} catch (e) {
  console.error("fsevents NOT available", err.message);
}
