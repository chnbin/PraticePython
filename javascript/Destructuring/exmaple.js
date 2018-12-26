const savedFile = {
  extension: 'jpg',
  name: 'report',
  size: 14040,
};

/**
 * Return summary of file.
 * @param {savedFile} file
 * @return {string} Summary of file.
 */
function fileSummary(file) {
  return `The file ${file.name}.${file.extension} is of size ${file.size}.`;
}

console.log(fileSummary(savedFile));
