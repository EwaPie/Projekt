#ifndef USER_FILELOADER_H
#define USER_FILELOADER_H

#include <string>
#include "AbstractUserRepository.h"

class FileUserRepository : public AbstractUserRepository
{
public:
    std::vector<User> load() override;

    bool save(std::vector<User> userList) override;

    FileUserRepository(const std::string &fileName);

private:
    std::string fileName;

    User getUserFromLine(std::string line);
};


#endif //USER_FILELOADER_H
